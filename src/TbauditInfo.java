import java.util.Date;

public class TbauditInfo {
    private Long iauditid;

    private String coperatorsn;

    private Short ioptype;

    private String copcontent;

    private Short ieventresult;

    private String copersignature;

    private Date dopstart;

    private Date dopend;

    private Date daudittime;

    private Short iauditresult;

    private String cauditopersn;

    private String cauditopersign;

    private String copername;

    private String cauditoption;

    public Long getIauditid() {
        return iauditid;
    }

    public void setIauditid(Long iauditid) {
        this.iauditid = iauditid;
    }

    public String getCoperatorsn() {
        return coperatorsn;
    }

    public void setCoperatorsn(String coperatorsn) {
        this.coperatorsn = coperatorsn == null ? null : coperatorsn.trim();
    }

    public Short getIoptype() {
        return ioptype;
    }

    public void setIoptype(Short ioptype) {
        this.ioptype = ioptype;
    }

    public String getCopcontent() {
        return copcontent;
    }

    public void setCopcontent(String copcontent) {
        this.copcontent = copcontent == null ? null : copcontent.trim();
    }

    public Short getIeventresult() {
        return ieventresult;
    }

    public void setIeventresult(Short ieventresult) {
        this.ieventresult = ieventresult;
    }

    public String getCopersignature() {
        return copersignature;
    }

    public void setCopersignature(String copersignature) {
        this.copersignature = copersignature == null ? null : copersignature.trim();
    }

    public Date getDopstart() {
        return dopstart;
    }

    public void setDopstart(Date dopstart) {
        this.dopstart = dopstart;
    }

    public Date getDopend() {
        return dopend;
    }

    public void setDopend(Date dopend) {
        this.dopend = dopend;
    }

    public Date getDaudittime() {
        return daudittime;
    }

    public void setDaudittime(Date daudittime) {
        this.daudittime = daudittime;
    }

    public Short getIauditresult() {
        return iauditresult;
    }

    public void setIauditresult(Short iauditresult) {
        this.iauditresult = iauditresult;
    }

    public String getCauditopersn() {
        return cauditopersn;
    }

    public void setCauditopersn(String cauditopersn) {
        this.cauditopersn = cauditopersn == null ? null : cauditopersn.trim();
    }

    public String getCauditopersign() {
        return cauditopersign;
    }

    public void setCauditopersign(String cauditopersign) {
        this.cauditopersign = cauditopersign == null ? null : cauditopersign.trim();
    }

    public String getCopername() {
        return copername;
    }

    public void setCopername(String copername) {
        this.copername = copername == null ? null : copername.trim();
    }

    public String getCauditoption() {
        return cauditoption;
    }

    public void setCauditoption(String cauditoption) {
        this.cauditoption = cauditoption == null ? null : cauditoption.trim();
    }
}