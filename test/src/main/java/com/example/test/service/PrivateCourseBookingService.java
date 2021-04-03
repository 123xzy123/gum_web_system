package com.example.test.service;

import com.example.test.entity.PrivateCourseBooking;

import java.util.List;

public interface PrivateCourseBookingService {
    List<PrivateCourseBooking> getPrivateCourseBookingList(String userName, String coachName, int page, int limit);
    PrivateCourseBooking getPrivateCourseBookingById(Integer bookingId);
    int getPrivateCourseBookingListCount();
    int addPrivateCourseBooking(PrivateCourseBooking privateCourseBooking);
    int updatePrivateCourseBooking(PrivateCourseBooking privateCourseBooking);
    int deletePrivateCourseBooking(Integer bookingId);
}
