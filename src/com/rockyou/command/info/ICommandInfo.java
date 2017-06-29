package com.rockyou.command.info;

import com.rockyou.storage.Key;
import com.rockyou.storage.Value;

public interface ICommandInfo {

	public Key getKey() ;
	public Value getValue();
	public int expireTime();
}
