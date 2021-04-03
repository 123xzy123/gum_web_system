package com.example.test.serviceImpl;

import com.example.test.entity.PrivateCourseBooking;
import com.example.test.mapper.PrivateCourseBookingMapper;
import com.example.test.service.PrivateCourseBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrivateCourseBookingServiceImpl implements PrivateCourseBookingService {
    @Autowired
    private PrivateCourseBookingMapper privateCourseBookingMapper;

    @Override
    public List<PrivateCourseBooking> getPrivateCourseBookingList(String userName, String coachName, int page, int limit) {
        System.out.println("userName:["+userName+"], coachName:["+coachName+"]");
        return privateCourseBookingMapper.getPrivateCourseBookingList(userName, coachName, page, limit);
    }

    @Override
    public PrivateCourseBooking getPrivateCourseBookingById(Integer bookingId) {
        return privateCourseBookingMapper.getPrivateCourseBookingById(bookingId);
    }

    @Override
    public int getPrivateCourseBookingListCount() {
        return privateCourseBookingMapper.getPrivateCourseBookingListCount();
    }

    @Override
    public int addPrivateCourseBooking(PrivateCourseBooking privateCourseBooking) {
        return privateCourseBookingMapper.addPrivateCourseBooking(privateCourseBooking);
    }

    @Override
    public int updatePrivateCourseBooking(PrivateCourseBooking privateCourseBooking) {
        return privateCourseBookingMapper.updatePrivateCourseBooking(privateCourseBooking);
    }

    @Override
    public int deletePrivateCourseBooking(Integer bookingId) {
        return privateCourseBookingMapper.deletePrivateCourseBooking(bookingId);
    }
}
