package com.example.hfs.simplemvp.base;




import android.support.annotation.NonNull;

public interface BasePresenter<T extends BaseView> {
	
	   void attachUi(@NonNull T view);
	   
	   void detachUi();
}
