package com.example.test.mapper;

import com.example.test.entity.PrivateCourseBooking;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PrivateCourseBookingMapper {
    List<PrivateCourseBooking> getPrivateCourseBookingList(@Param("userName") String userName,
                                                           @Param("coachName") String coachName,
                                                           @Param("page") int page,
                                                           @Param("limit") int limit
    );

    PrivateCourseBooking getPrivateCourseBookingById(@Param("bookingId") Integer bookingId);
    int getPrivateCourseBookingListCount();
    int addPrivateCourseBooking(@Param("privateCourseBooking") PrivateCourseBooking privateCourseBooking);
    int updatePrivateCourseBooking(@Param("privateCourseBooking") PrivateCourseBooking privateCourseBooking);
    int deletePrivateCourseBooking(@Param("bookingId") Integer bookingId);

}
