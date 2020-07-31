package vn.daikon.myapplication;

import android.content.Intent;
import android.util.Log;

import java.util.ArrayList;

import vn.daikon.myapplication.model.NhanVien;
import vn.daikon.myapplication.repo.NhanVienRepo;

public class State {
    private static State state = null;

    public static State getInstance(){
        if (state == null) {
            state = new State();
        }
        return state;
    }
    public void setRepo(NhanVienRepo nhanVienRepo){
        this.nhanVienRepo = nhanVienRepo;
    }
    public NhanVien nhanVien;
    private NhanVienRepo nhanVienRepo;




    public boolean login(String user, String pass){
        NhanVien nhanVien = nhanVienRepo.getNhanVien(user);
        if (nhanVien != null && nhanVien.password.equals(pass))
        {
            state.nhanVien = nhanVien;
            return true;
        }
        else return false;
    }
    public void createNhanVien(NhanVien nhanVien){
        NhanVien nhanVien2 = nhanVienRepo.getNhanVien(nhanVien.user);
        if (nhanVien2 == null) {
            nhanVienRepo.addNhanVien(nhanVien);
        }
    }
    public void updateNhanVien(NhanVien nhanVien){
        NhanVien nhanVien2 = nhanVienRepo.getNhanVien(nhanVien.user);

        if (nhanVien2 != null) {
            nhanVienRepo.updateNhanVien(nhanVien);
            state.nhanVien = nhanVien;

        }
    }

}
