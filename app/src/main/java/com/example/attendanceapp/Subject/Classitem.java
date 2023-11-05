package com.example.attendanceapp.Subject;

public class Classitem {
  private   String Domainname;
   private String SubjentName;

    public Classitem(String domainname, String subjentName) {
        Domainname = domainname;
        SubjentName = subjentName;
    }

    public String getDomainname() {
        return Domainname;
    }

    public void setDomainname(String domainname) {
        Domainname = domainname;
    }

    public String getSubjentName() {
        return SubjentName;
    }

    public void setSubjentName(String subjentName) {
        SubjentName = subjentName;
    }
}
