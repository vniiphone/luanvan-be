package com.luanvan.b1910025.services;

import com.luanvan.b1910025.models.Booking;
import com.luanvan.b1910025.models.Tour;
import com.luanvan.b1910025.models.User;
import com.luanvan.b1910025.payloads.requests.BookingRequest;
import com.luanvan.b1910025.payloads.responses.BookingResponse;
import com.luanvan.b1910025.repository.BookingRepo;
import com.luanvan.b1910025.repository.TourRepo;
import com.luanvan.b1910025.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.source.InvalidConfigurationPropertyValueException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    TourRepo tourRepo;
    @Autowired
    UserRepo userRepo;
    @Autowired
    BookingRepo bookingRepo;


    @Override
    @Transactional
    public Booking createBooking(BookingRequest bookingRequest) {
        User user = userRepo.findById(bookingRequest.getUser_id()).orElseThrow();
        Tour tour = tourRepo.findById(bookingRequest.getTour_id()).orElseThrow();
        Booking cartItem = new Booking(user, tour, bookingRequest.getSoLuongVeDat());
//        if((tour.getSoLuongVe()<bookingRequest.getSoLuongVe())||(tour.getSoLuongVe()<=0))
//        {
////            return new BookingResponse(cartItem, null, "Hết Vé!");
//        }
        Booking isInCart = bookingRepo.findByUser_IdAndTour_IdAndStatusDat(bookingRequest.getUser_id(), bookingRequest.getTour_id(), 0);
        if (isInCart != null) {
            if (isInCart.getSoLuongVeDat() + bookingRequest.getSoLuongVeDat() <= isInCart.getTour().getSoLuongVe())
                isInCart.setSoLuongVeDat(isInCart.getSoLuongVeDat() + bookingRequest.getSoLuongVeDat());
            else
                isInCart.setSoLuongVeDat(isInCart.getTour().getSoLuongVe());
            return bookingRepo.save(isInCart);

//            return new BookingResponse(isInCart, null, "Cart Cập nhật");
        } else {
            return bookingRepo.save(cartItem);

//            return new BookingResponse(cartItem, null, "Cart Đã Thêm");
        }
    }

    @Override
    public BookingResponse createBooking2(BookingRequest cartItemRequest) {
        // TODO Auto-generated method stub
        User user = userRepo.findById(cartItemRequest.getUser_id()).orElseThrow();
        Tour tour = tourRepo.findById(cartItemRequest.getTour_id()).orElseThrow();
        Booking cartItem = new Booking(user, tour, cartItemRequest.getSoLuongVeDat());
        if ((tour.getSoLuongVe() < cartItemRequest.getSoLuongVeDat())) {
            return new BookingResponse(cartItem, null, "Hết Vé");
        }
        Booking isInCart = bookingRepo.findByUser_IdAndTour_IdAndStatusDat(cartItemRequest.getUser_id(), cartItemRequest.getTour_id(), 0);
        if (isInCart != null) {
            if (isInCart.getSoLuongVeDat() + cartItemRequest.getSoLuongVeDat() <= isInCart.getTour().getSoLuongVe())
                isInCart.setSoLuongVeDat(isInCart.getSoLuongVeDat() + cartItemRequest.getSoLuongVeDat());
            else
                isInCart.setSoLuongVeDat(isInCart.getTour().getSoLuongVe());
            bookingRepo.save(isInCart);
            // cập nhật số lượng Vé trên tour
//            tour.setSoLuongVe(tour.getSoLuongVe() - cartItemRequest.getSoLuongVeDat());
//            tourRepo.save(tour);
            return new BookingResponse(isInCart, null, "Cart Cập Nhật");
        } else {
            bookingRepo.save(cartItem);
            // cập nhật số lượng vé  trên tour
//            tour.setSoLuongVe(tour.getSoLuongVe() - cartItemRequest.getSoLuongVeDat());
//            tourRepo.save(tour);
            return new BookingResponse(cartItem, null, "Cart Added");
        }
    }

    @Override
    public Optional<Booking> updateBooking(long bookingId, BookingRequest bookingRequest) {
        // TODO Auto-generated method stub
        Optional<Booking> cartItem = bookingRepo.findById(bookingId);
        Tour tour = tourRepo.findById(bookingRequest.getTour_id()).orElseThrow();

        if (cartItem.isPresent()) {

            tour = cartItem.get().getTour();
            int oldQuantity = cartItem.get().getSoLuongVeDat();
            int newQuantity = bookingRequest.getSoLuongVeDat();
            int diffQuantity = newQuantity - oldQuantity;

            if ((tour.getSoLuongVe() < bookingRequest.getSoLuongVeDat())) {
                throw new RuntimeException("Không đủ số vé!");
            }

//            tour.setSoLuongVe(tour.getSoLuongVe() - diffQuantity);
            cartItem.get().setSoLuongVeDat(newQuantity);

            bookingRepo.save(cartItem.get());
//            tourRepo.save(tour);

            return cartItem;
        } else {
            throw new InvalidConfigurationPropertyValueException("bookingId", bookingId, "Not found");
        }
    }

    @Override
    public void deteleBooking(long bookingId) {
        Optional<Booking> cartItem = bookingRepo.findById(bookingId);

        if (cartItem.isPresent()) {
//            Tour tour = cartItem.get().getTour();
//            int quantity = cartItem.get().getSoLuongVeDat();

//            tour.setSoLuongVe(tour.getSoLuongVe() + quantity);
            bookingRepo.deleteById(bookingId);
//            tourRepo.save(tour);
        } else {
            throw new InvalidConfigurationPropertyValueException("bookingId", bookingId, "Not Found");
        }
    }

    @Override
    public List<Booking> getBooking(long userId) {
        // TODO Auto-generated method stub
        List<Booking> list = bookingRepo.findByUser_Id(userId);
        List<Booking> list2 = new ArrayList<>();

        for (Booking cartItem : list) {
            if (cartItem.getStatusDat() == 0)
                list2.add(cartItem);
        }
        return list2;
    }


    @Override
    public Booking getASingleBooking(Long bookingId) {

        return bookingRepo.findById(bookingId)
                .orElseThrow(() -> new InvalidConfigurationPropertyValueException("bookingId", bookingId, "Not found"));

    }

}
