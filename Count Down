    class countDown {
        private int limitSec;
        public countDown(int limitSec) throws InterruptedException{
            this.limitSec = limitSec;
            System.out.println("Count from "+limitSec);
            while(limitSec > 0){
                System.out.println("remians "+ --limitSec +" s");
                TimeUnit.SECONDS.sleep(1);
            }
            System.out.println("Time is out");
        }
        public static void main(String[] args) throws InterruptedException  {
            new countDown(60);
    }
