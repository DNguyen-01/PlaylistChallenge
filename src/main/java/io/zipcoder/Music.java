package io.zipcoder;

public class Music {

    private String[] playList;

    public Music(String[] playList){
        this.playList = playList;
    }

    public Integer selection(Integer startIndex, String selection) {

        //return the smallest number between going up/down the list
        //create a placeholder for the current position
        //get the amount of press it takes going up on the list
        //get the amount of press it takes going down the list
        //return the smallest number between the two
        Integer minimumPresses = Integer.MAX_VALUE;
        //get the length of the playlist pressing down
        int currentIndex = startIndex;
        for (int i = 0; i < playList.length; i++) {
            if (playList[(startIndex + i) % playList.length].equalsIgnoreCase(selection)) { //this finds us the song we're looking for
                minimumPresses = i; //as i increments through the indices, that represents the amount of times we are pressing down
                System.out.println("Minimum Press: " + minimumPresses);
                break;
            }
        }
        //getting the minimum pressings up
        for (int i = 1; i < playList.length; i++) { //note the starting position of i - because we're always decrementing
            currentIndex--;
            if (currentIndex < 0) {
                currentIndex = playList.length - 1;
            }
            if (playList[currentIndex].equalsIgnoreCase(selection)) {
                minimumPresses = Math.min(minimumPresses, i); //at this point, we either have found the min going down/up - find me the smallest between max value and the i.
                System.out.println("Minimum Presses: " + minimumPresses);
                break;
            }
        }
        if (minimumPresses == Integer.MAX_VALUE) {

            return null;

        } else {
            return minimumPresses;
        }
    }
}
