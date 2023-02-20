package ICAI.designPatterns.patternBehavioral.ChainOfResponsibility;

import ICAI.entity.UserDetails;
import ICAI.service.*;


public class UserExistHandler extends Handler {

    UserDetailService userDetailService = new UserDetailService();

    @Override
    public boolean handle( String artist, String song ) {
        for (UserDetails ud : userDetailService.getAllUserDetails()) {
            if (ud.getName().equals(artist)) {
                System.out.println("Approved by admin \n");
                return true;
            }
        }
        return handleNext(artist, song);
    }

}


