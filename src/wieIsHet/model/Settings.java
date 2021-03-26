package wieIsHet.model;

/**
 * Deze klasse verzamelt de verschillende settings voor het spel. Voor elke setting is een getter en een setter.
 * <p>
 * In v2.0 zal er meerdere settings toegevoegd worden zoals soorteerfunctie, enz.
 *
 * @version 1.0
 * @author LeventHAN
 */
public class Settings {
    private boolean autoPickEnable = false;

    Settings() {
    }

    public void setAutoPickEnable(boolean autoPickEnable) {
        this.autoPickEnable = autoPickEnable;
    }

    public boolean isCbAutoPickEnable() {
        return autoPickEnable;
    }
}