package CSE102Midterm;

public class Cargo extends Payload {
    private boolean pressurized;
    private String type;

    public Cargo(){
        this.pressurized = false;
    }
    public Cargo(boolean pressurized, String type){
        this.pressurized = pressurized;
        this.type = type;
    }

    public boolean isPressurized() {
        return pressurized;
    }

    public void setPressurized(boolean pressurized) {
        this.pressurized = pressurized;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
