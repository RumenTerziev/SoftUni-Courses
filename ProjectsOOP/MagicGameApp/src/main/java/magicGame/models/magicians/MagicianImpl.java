package magicGame.models.magicians;

import magicGame.models.magics.Magic;
import magicGame.models.magics.MagicImpl;

import static magicGame.common.ExceptionMessages.*;

public abstract class MagicianImpl implements Magician {


    private String username;
    private int health;
    private int protection;
    private boolean isAlive;
    private Magic magic;

    protected MagicianImpl(String username, int health, int protection, Magic magic) {
        setUsername(username);
        setHealth(health);
        setProtection(protection);
        setMagic(magic);
        this.isAlive = true;
    }

    protected void setUsername(String username) {

        if (username == null || username.trim().isEmpty()) {
            throw new NullPointerException(INVALID_MAGICIAN_NAME);
        }

        this.username = username;
    }

    protected void setHealth(int health) {

        if (health < 0) {
            throw new IllegalArgumentException(INVALID_MAGICIAN_HEALTH);
        }
        this.health = health;
    }

    protected void setProtection(int protection) {

        if (protection < 0) {
            throw new IllegalArgumentException(INVALID_MAGICIAN_PROTECTION);
        }
        this.protection = protection;
    }

    protected void setMagic(Magic magic) {
        if (magic == null) {
            throw new IllegalArgumentException(INVALID_MAGIC);
        }
        this.magic = magic;
    }


    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public int getProtection() {
        return protection;
    }

    @Override
    public Magic getMagic() {
        return magic;
    }

    @Override
    public boolean isAlive() {
        isAlive = health > 0;
        return this.isAlive;
    }

    @Override
    public void takeDamage(int points) {

        int currentPoints = points - protection;

        setProtection(Math.max(protection - points, 0));

        if (currentPoints > 0) {
            setHealth(Math.max(health - currentPoints, 0));
        }

    }

    @Override
    public String toString() {

        return String.format("%s: %s", getClass().getSimpleName(), username) +
                System.lineSeparator() +
                String.format("Health: %d", health) +
                System.lineSeparator() +
                String.format("Protection: %d", protection) +
                System.lineSeparator() +
                String.format("Magic: %s", magic.getName());
    }
}
