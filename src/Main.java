


class Main {

    public static void main(String [] args) {

        System.out.println("Greeeeeen narwals: Nima & Sherin");
        ImageEngine wheelie = new ImageEngine("input_pics/wheelie.png");

        wheelie.colorSwap( '3');
        wheelie.write();
        /*  1 - r to g
            2 - g to b
            3 - b to r
         */

    }

}
