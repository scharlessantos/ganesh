// ========================================================================
// Copyright (c) 2006-2009 Mort Bay Consulting Pty. Ltd.
// ------------------------------------------------------------------------
// All rights reserved. This program and the accompanying materials
// are made available under the terms of the Eclipse Public License v1.0
// and Apache License v2.0 which accompanies this distribution.
// The Eclipse Public License is available at 
// http://www.eclipse.org/legal/epl-v10.html
// The Apache License v2.0 is available at
// http://www.opensource.org/licenses/apache2.0.php
// You may elect to redistribute this code under either of these licenses. 
// ========================================================================

package org.eclipse.jetty.io;

import java.io.EOFException;

public class EofException extends EOFException
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2163314784019878860L;

	public EofException()
	{}

	public EofException(String reason)
	{
		super(reason);
	}

	public EofException(Throwable th)
	{
		if (th != null)
			initCause(th);
	}
}