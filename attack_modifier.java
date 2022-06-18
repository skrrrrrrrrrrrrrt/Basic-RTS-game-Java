public class attack_modifier implements modifiers{
    String tag;
    int stoinost;

    public attack_modifier(String tag, int stoinost) {
        this.tag = tag;
        this.stoinost = stoinost;
    }

    @Override
    public int modifier() {
        return stoinost;
    }

    @Override
    public String getmodifiertype() {
        return tag;
    }
}
