package be.pxl.ja.streamingservice.account;

import be.pxl.ja.streamingservice.exception.TooManyProfilesException;
import be.pxl.ja.streamingservice.model.StreamingPlan;
import be.pxl.ja.streamingservice.util.PasswordUtil;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private static final int MINIMUM_PASSWORD_STRENGTH = 5;
    private String email;
    private String password;
    private PaymentInfo paymentInfo;
    private StreamingPlan streamingPlan;
    private List<Profile> profiles = new ArrayList<>();

    public Account(String email, String password) {
        if (email != null & password != null) {
            if (email.contains("@"))
                this.email = email;
            else {
                throw new IllegalArgumentException();
            }
            if (password.length() == 5) {
                this.password = password;
            } else {
                throw new IllegalArgumentException();
            }
            this.profiles.add(new Profile("Profile1"));
            this.streamingPlan = StreamingPlan.BASIC;
        } else {
            throw new IllegalArgumentException();
        }
    }


    public void setStreamingPlan(StreamingPlan streamingPlan) {
        this.streamingPlan = streamingPlan;
    }

    public void addProfile(Profile profile) throws TooManyProfilesException {
        if (profiles.size() < streamingPlan.getNumberOfScreens()) {
            profiles.add(profile);
        } else {
            throw new TooManyProfilesException(profile);
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean verifyPassword(String password) {
        return PasswordUtil.isValid(password, this.password);
    }

    public void setPaymentInfo(PaymentInfo paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    public void setPassword(String password) {
        try {
            this.password = PasswordUtil.encodePassword(password);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    public Profile getFirstProfile() {
        return profiles.get(0);
    }

    public int getNumberOfProfiles() {
        return profiles.size();
    }

    // sorteren van profiles
    public List<Profile> getProfiles() {
        return profiles;
    }
}
