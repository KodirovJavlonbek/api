package com.example.api.dto;

import jdk.nashorn.internal.objects.annotations.Setter;
import lombok.Getter;

public class Company_Info {
        private  int   id;
        private  String   order_office;
        private  String   company_id;
        private  String   name;
        private  String   ceo;
        private  String   address;
        private  String   type;
        private  String   type2;
        private  String   email;
        private  String   email2;
        private  String   email_request;
        private  String   fax;
        private  int   tax_on;
        private  String   method;
        private  String   order_man;
        private  String   phone;
        private  String   phone_ceo;
        private  int   date_payment;
        private  String   login_id;
        private  String   login_passwd;

    public Company_Info(int id, String order_office, String company_id, String name, String ceo, String address, String type, String type2, String email, String email2, String email_request, String fax, int tax_on, String method, String order_man, String phone, String phone_ceo, int date_payment, String login_id, String login_passwd) {
        this.id = id;
        this.order_office = order_office;
        this.company_id = company_id;
        this.name = name;
        this.ceo = ceo;
        this.address = address;
        this.type = type;
        this.type2 = type2;
        this.email = email;
        this.email2 = email2;
        this.email_request = email_request;
        this.fax = fax;
        this.tax_on = tax_on;
        this.method = method;
        this.order_man = order_man;
        this.phone = phone;
        this.phone_ceo = phone_ceo;
        this.date_payment = date_payment;
        this.login_id = login_id;
        this.login_passwd = login_passwd;
    }

    public Company_Info() {
    }

    public int getId() {
        return id;
    }

    public String getOrder_office() {
        return order_office;
    }

    public String getCompany_id() {
        return company_id;
    }

    public String getName() {
        return name;
    }

    public String getCeo() {
        return ceo;
    }

    public String getAddress() {
        return address;
    }

    public String getType() {
        return type;
    }

    public String getType2() {
        return type2;
    }

    public String getEmail() {
        return email;
    }

    public String getEmail2() {
        return email2;
    }

    public String getEmail_request() {
        return email_request;
    }

    public String getFax() {
        return fax;
    }

    public int getTax_on() {
        return tax_on;
    }

    public String getMethod() {
        return method;
    }

    public String getOrder_man() {
        return order_man;
    }

    public String getPhone() {
        return phone;
    }

    public String getPhone_ceo() {
        return phone_ceo;
    }

    public int getDate_payment() {
        return date_payment;
    }

    public String getLogin_id() {
        return login_id;
    }

    public String getLogin_passwd() {
        return login_passwd;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setOrder_office(String order_office) {
        this.order_office = order_office;
    }

    public void setCompany_id(String company_id) {
        this.company_id = company_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCeo(String ceo) {
        this.ceo = ceo;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setType2(String type2) {
        this.type2 = type2;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    public void setEmail_request(String email_request) {
        this.email_request = email_request;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public void setTax_on(int tax_on) {
        this.tax_on = tax_on;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void setOrder_man(String order_man) {
        this.order_man = order_man;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPhone_ceo(String phone_ceo) {
        this.phone_ceo = phone_ceo;
    }

    public void setDate_payment(int date_payment) {
        this.date_payment = date_payment;
    }

    public void setLogin_id(String login_id) {
        this.login_id = login_id;
    }

    public void setLogin_passwd(String login_passwd) {
        this.login_passwd = login_passwd;
    }

    @Override
    public String toString() {
        return "Company_Info{" +
                "id=" + id +
                ", order_office='" + order_office + '\'' +
                ", company_id='" + company_id + '\'' +
                ", name='" + name + '\'' +
                ", ceo='" + ceo + '\'' +
                ", address='" + address + '\'' +
                ", type='" + type + '\'' +
                ", type2='" + type2 + '\'' +
                ", email='" + email + '\'' +
                ", email2='" + email2 + '\'' +
                ", email_request='" + email_request + '\'' +
                ", fax='" + fax + '\'' +
                ", tax_on=" + tax_on +
                ", method='" + method + '\'' +
                ", order_man='" + order_man + '\'' +
                ", phone='" + phone + '\'' +
                ", phone_ceo='" + phone_ceo + '\'' +
                ", date_payment=" + date_payment +
                ", login_id='" + login_id + '\'' +
                ", login_passwd='" + login_passwd + '\'' +
                '}';
    }
}
