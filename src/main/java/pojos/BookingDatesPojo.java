package pojos;

public class BookingDatesPojo {
    //tüm keyler için privte variabler oluşturuyoruz
    private String checkin;
    private String checkout;

    //tüm parametrelerle  ve parametresiz consractır  oluşturuyoruz

    public BookingDatesPojo(String checkin, String checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public BookingDatesPojo() {
    }
      // getter setter oluştur

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }
    //to sitring methodunu oluştur

    @Override
    public String toString() {
        return "BookingDatesPojo{" +
                "checkin='" + checkin + '\'' +
                ", checkout='" + checkout + '\'' +
                '}';
    }
}
