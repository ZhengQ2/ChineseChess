    /**
     * This timer will countdown for 60 seconds after either player 
     * move their pieces
     * @param red the side of the action performer
     * @return an integer for determaining the loser
     */
    public static int countDown(boolean red) {
        limit = 60; //set the timer back to 60s
        
        if (red) {
            Timer timer = new Timer(); //declear a timer for red team

            timer.scheduleAtFixedRate(new TimerTask() {

                public void run() {
                    limit--;
                    time.setText(limit); //upload the remaining time to the GUI
                    if (limit == 0) {
                        timer.cancel();//stop the timer
                    }
                }

            }, 0, 1000); //start 0 seconds later, repeat once per second

        } else {
            Timer timer2 = new Timer(); //declear a timer for black team

            timer2.scheduleAtFixedRate(new TimerTask() {

                public void run() {
                    limit--;
                    time.setText(limit); //upload the remaining time to the GUI
                    if (limit == 0) {
                        timer2.cancel(); //stop the timer
                    }
                }

            }, 0, 1000); //start 0 seconds later, repeat once per second

        }

        if (limit == 0 && red) {
            return 1; //red lose
        } else if (limit == 0 && !red) {
            return -1; //black lose
        } else {
            return 0; //no result
        }
    }
