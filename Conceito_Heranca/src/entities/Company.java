package entities;

public class Company extends User {
    private String site;
    private String contact;
    private String phone;
    private String cnpj;
    private String ie;

    public Company() {
        super();
        site = new String();
        contact = new String();
        phone = new String();
        cnpj = new String();
        ie = new String();
    }


    public Company(Integer id, String name, String email, String password, String site, String contact, String phone,
            String cnpj, String ie) {
        super(id, name, email, password);
        this.site = site;
        this.contact = contact;
        this.phone = phone;
        this.cnpj = cnpj;
        this.ie = ie;
    }


    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getIe() {
        return ie;
    }

    public void setIe(String ie) {
        this.ie = ie;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Site: ").append(site).append("\n");
        sb.append("Contato: ").append(contact).append("\n");
        sb.append("Telefone: ").append(phone).append("\n");
        sb.append("CNPJ: ").append(cnpj).append("\n");
        sb.append("IE: ").append(ie).append("\n");
        sb.append("####################################################");
        return sb.toString();
    }

}
