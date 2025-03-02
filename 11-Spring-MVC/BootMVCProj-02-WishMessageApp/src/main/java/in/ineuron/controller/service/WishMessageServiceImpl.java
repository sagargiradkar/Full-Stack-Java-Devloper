package in.ineuron.controller.service;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class WishMessageServiceImpl implements IWishMessageService{
    @Override
    public String generateWishMessage() {

        LocalDateTime ldt = LocalDateTime.now();
        int hour = ldt.getHour();
        if(hour < 12)
            return  "Good Morning";
        else if (hour < 16)
            return "Good Afternoon";
        else if(hour < 20)
            return "Good Evening";
        else
            return "Good Night";
    }
}
