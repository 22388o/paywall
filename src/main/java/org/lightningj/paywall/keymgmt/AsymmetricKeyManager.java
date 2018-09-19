/*
 ************************************************************************
 *                                                                       *
 *  LightningJ                                                           *
 *                                                                       *
 *  This software is free software; you can redistribute it and/or       *
 *  modify it under the terms of the GNU General Public License          *
 *  License as published by the Free Software Foundation; either         *
 *  version 3 of the License, or any later version.                      *
 *                                                                       *
 *  See terms of license at gnu.org.                                     *
 *                                                                       *
 *************************************************************************/

package org.lightningj.paywall.keymgmt;

import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * Base interface for a KeyManager in charge of maintaining asymmetric keys.
 *
 * Created by Philip Vendil on 2018-09-14.
 */
public interface AsymmetricKeyManager extends KeyManager{

    /**
     * Returns the public key that should be used for asymmetric operations for the given context.
     *
     * @param context related context.
     * @return related public key.
     * @throws UnsupportedOperationException if operation in combination with given context isn't
     * supported.
     */
    PublicKey getPublicKey(Context context) throws UnsupportedOperationException;

    /**
     * Returns the private key that should be used for asymmetric operations for the given context.
     *
     * @param context related context.
     * @return related private key.
     * @throws UnsupportedOperationException if operation in combination with given context isn't
     * supported.
     */
    PrivateKey getPrivateKey(Context context) throws UnsupportedOperationException;

    /**
     * Method to verify if a given public key is trusted.
     *
     * @param context related context.
     * @param publicKey the public key to check if trusted.
     * @return true if the public key is trusted for the given context.
     * @throws UnsupportedOperationException
     */
    boolean isTrusted(Context context, PublicKey publicKey) throws UnsupportedOperationException;
}
