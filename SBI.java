class SBI extends Bank {
    @Override
    public float getRateOfInterest(int capitale) {
        float interesse = 0;
        if (capitale > 10000) {
            interesse = capitale * 7 / 100;
        } else {
            interesse = capitale * 10 / 100;
        }
        return interesse;
    }
}
