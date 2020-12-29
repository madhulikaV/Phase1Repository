package com.LockedMe.bo;

import com.LockedMe.exception.FileException;

public interface FileOperationBO {

	public void addFileOp() throws FileException;

	public boolean deleteFileOp() throws FileException;

	public void fileSearchOp() throws FileException;

}
