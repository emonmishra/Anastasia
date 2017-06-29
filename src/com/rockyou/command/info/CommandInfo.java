package com.rockyou.command.info;

import com.rockyou.storage.Key;
import com.rockyou.storage.Value;

public class CommandInfo implements ICommandInfo {
    @Override
    public Key getKey() {
        return null;
    }

    @Override
    public Value getValue() {
        return null;
    }

    @Override
    public int expireTime() {
        return 0;
    }
}
