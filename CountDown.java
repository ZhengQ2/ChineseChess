    public static boolean countDown(boolean red) {
        if(red) {
            Timer timer = new Timer();
            
            timer.scheduleAtFixedRate(new TimerTask() {
                
                public void run() {
                    limit --;
                    System.out.println(limit);
                    if(limit == 0) {
                        timer.cancel();
                    }
                }
               
            },0, 1000);
            
        } else {
            Timer timer2 = new Timer();
            
            timer2.scheduleAtFixedRate(new TimerTask() {
                
                public void run() {
                    limit --;
                    System.out.println(limit);
                    if(limit == 0) {
                        timer2.cancel();
                    }
                }
               
            },0, 1000);
            
        }
        return false;
    }
