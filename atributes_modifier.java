public class atributes_modifier implements modifiers{
    String atribute;
    public int stoinost;


    public atributes_modifier(String atribute, int stoinost) {
        this.atribute = atribute;
        this.stoinost = stoinost;
    }

    @Override
    public int modifier() {
        return  stoinost;
    }
    public String getmodifiertype() {
        return atribute;
    }
}
