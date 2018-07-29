package com.example.michael.nbaplayer;

import java.sql.Struct;

/**
 * Created by michael on 12/5/17.
 */

public class Player {
    String firstName;
    String lastName;
    String jersey;
    String pos;
    String posExpanded;
    String heightFeet;
    String heightInches;
    String weightPounds;
    String personId;
    boolean isAllStar;
    String orderChar;
    String playerUrl;
    String displayName;

    teamData teamData;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setJersey(String jersey) {
        this.jersey = jersey;
    }

    public String getJersey() {
        return jersey;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public String getPos() {
        return pos;
    }

    public void setPosExpanded(String posExpanded) {
        this.posExpanded = posExpanded;
    }

    public String getPosExpanded() {
        return posExpanded;
    }

    public void setHeightFeet(String heightFeet) {
        this.heightFeet = heightFeet;
    }

    public String getHeightFeet() {
        return heightFeet;
    }

    public void setHeightInches(String heightInches) {
        this.heightInches = heightInches;
    }

    public String getHeightInches() {
        return heightInches;
    }

    public void setWeightPounds(String weightPounds) {
        this.weightPounds = weightPounds;
    }

    public String getWeightPounds() {
        return weightPounds;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getPersonId() {
        return personId;
    }

    public void setAllStar(boolean isAllStar) {
        this.isAllStar = isAllStar;
    }

    public boolean getAllStar() {
        return isAllStar;
    }

    public void setOrderChar(String orderChar) {
        this.orderChar = orderChar;
    }

    public String getOrderChar() {
        return orderChar;
    }

    public void setPlayerUrl(String playerUrl) {
        this.playerUrl = playerUrl;
    }

    public String getPlayerUrl() {
        return playerUrl;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setTeamData(teamData t){
        this.teamData = t;
    }

    public teamData getTeamData() {
        return teamData;
    }

    public class teamData {
        String urlName;
        String city;
        String nickname;
        String tricode;

        public teamData() {}

        public void setUrlName(String urlName) {
            this.urlName = urlName;
        }

        public String getUrlName() {
            return urlName;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCity() {
            return city;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getNickname() {
            return nickname;
        }

        public void setTricode(String tricode) {
            this.tricode = tricode;
        }

        public String getTricode() {
            return tricode;
        }
    }
}
