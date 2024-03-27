package br.com.henrique.system.entities.enums;

public enum SectorName {
    HARDWARE(1), 
    PERIPHELRALS(2),
    ELECTRONICS(3),
    SMARTHPHONES(4);

    private int code;

    private SectorName(int code){
        this.code = code;
    }

    public int getCode(){
        return code;
    }

    public static SectorName valueOf(int code){
        for(SectorName value: SectorName.values()) {
            if(value.getCode() == code){
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid SectorName code");
    } 
}

