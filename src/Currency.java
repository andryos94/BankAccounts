public enum Currency {
    USD(1.0),
    RON(0.24),
    YEN(0.0092),
    EUR(1.12);

    private final double currency;
    private Currency(double currency) {
        this.currency = currency;
    }

    public double getCurrency() {
        return currency;
    }
}
