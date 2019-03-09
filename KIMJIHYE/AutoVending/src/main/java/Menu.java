public interface Menu {
    void showItems();
    default void doProcess() {
    }
    default void doProcess(int menuNum) {
    }
    default void showMenus() {
    }
    default boolean showCanBuy(int money) {
        return true;
    }
}
