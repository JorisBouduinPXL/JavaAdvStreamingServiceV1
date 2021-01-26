package be.pxl.ja.streamingservice.account;

import be.pxl.ja.streamingservice.exception.InvalidDateException;
import be.pxl.ja.streamingservice.model.Content;

import java.time.LocalDate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Profile {
    private String name;
    private LocalDate dateOfBirth;
    private List<Content> recentlyWatched = new ArrayList<>();
    private List<Content> currentlyWatching = new ArrayList<>();
    private Queue<Content> myList = new ArrayDeque<>();
    private String avatar;

    public Profile(String name) {
        this.name = name;
        avatar = "profile1";
    }

    public Profile(String name, String avatar) {
        this.name = name;
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        if (dateOfBirth.isAfter(LocalDate.now())) {
            throw new InvalidDateException(dateOfBirth);
        }
        this.dateOfBirth = dateOfBirth;
    }

    public String getAvatar() {
        return avatar;
    }

    public int getAge() {
        int leeftijd = LocalDate.now().getYear() - dateOfBirth.getYear();
        return leeftijd;
    }

    public void startWatching(Content content) {
        while (!currentlyWatching.contains(content)) {
            currentlyWatching.add(content);
        }
        for (Content c : myList) {
            if (c == content) {
                myList.remove(c);
            }
        }
    }

    public void finishWatching(Content content) {
        currentlyWatching.remove(content);
        recentlyWatched.add(content);
    }

    public void addToMyList(Content content) {
        while (!myList.contains(content)) {
            myList.add(content);
        }
    }

    public void removeFromMyList(Content content) {
        myList.remove(content);

    }

    public List<Content> getRecentlyWatched() {
        return recentlyWatched;
    }

    public List<Content> getCurrentlyWatching() {
        return currentlyWatching;
    }

    public Queue<Content> getMyList() {
        return myList;
    }

    public boolean isInMyList(Content content) {
        return myList.contains(content);
    }

    public boolean allowedToWatch(Content content) {
        return content.getMaturityRating().getMinimumAge() >= getAge();
    }
}
