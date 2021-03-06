package com.njsdklib.ane;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;
import com.njsdklib.extensions.ErayCommonJavaContext;
import cn.cmgame.billing.api.game.main.Listener;
import cn.cmgame.billing.api.game.main.Tool;

public class ANEadNativeInit implements FREFunction {
	private ErayCommonJavaContext _context = null;
	@Override
	public FREObject call(FREContext context,FREObject[] arg1) {
		// TODO Auto-generated method stub
		_context = (ErayCommonJavaContext) context;
		FREObject b = null;

		Tool.adNativeInit(_context.getActivity(), new Listener() {
			@Override
			public void onAdClick(String s) {
				_context.dispatchStatusEventAsync("onAdClick",s);
			}

			@Override
			public void onAdClosed(String s) {
				_context.dispatchStatusEventAsync("onAdClosed",s);
			}

			@Override
			public void onAdFailed(String s) {
				_context.dispatchStatusEventAsync("onAdFailed",s);
			}

			@Override
			public void onAdInitFailed(String s) {
				_context.dispatchStatusEventAsync("onAdInitFailed",s);
			}

			@Override
			public void onAdInitSucessed(String s) {
				_context.dispatchStatusEventAsync("onAdInitSucessed",s);
			}

			@Override
			public void onAdNoAd(String s) {
				_context.dispatchStatusEventAsync("onAdNoAd",s);
			}

			@Override
			public void onAdPresent(String s) {
				_context.dispatchStatusEventAsync("onAdPresent",s);
			}
		});
		_context.dispatchStatusEventAsync("ANEadNativeInit","success");
		return b;
	}

}
