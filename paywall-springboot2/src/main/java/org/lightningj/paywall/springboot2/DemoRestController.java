/*
 * ***********************************************************************
 *                                                                       *
 *  LightningJ                                                           *
 *                                                                       *
 *  This software is free software; you can redistribute it and/or       *
 *  modify it under the terms of the GNU Lesser General Public License   *
 *  (LGPL-3.0-or-later)                                                  *
 *  License as published by the Free Software Foundation; either         *
 *  version 3 of the License, or any later version.                      *
 *                                                                       *
 *  See terms of license at gnu.org.                                     *
 *                                                                       *
 *************************************************************************/
package org.lightningj.paywall.springboot2;

import org.lightningj.paywall.annotations.PaymentRequired;
import org.lightningj.paywall.spring.PaywallProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;


// TODO
@PaymentRequired(articleId = "abc565")
@RestController
    public class DemoRestController {

        private static final String template = "DemoService, %s!";
        private final AtomicLong counter = new AtomicLong();

        private PaywallProperties paywallProperties;

        public DemoRestController(PaywallProperties paywallProperties){
            this.paywallProperties = paywallProperties;
        }

        @PaymentRequired(articleId = "abc123")
        @RequestMapping("/demo")
        public DemoResult demo1(@RequestParam(value="name", defaultValue="World") String name) {
            return new DemoResult(counter.incrementAndGet(),
                    String.format(template, name));
        }

    @PaymentRequired(articleId = "abcPayPerRequest", payPerRequest = true)
    @RequestMapping("/demoPayPerRequest")
    public DemoResult demoPayPerRequest(@RequestParam(value="name", defaultValue="Pay Per Request") String name) {
        return new DemoResult(counter.incrementAndGet(),
                String.format(template, name));
    }

    @RequestMapping("/demoNoPaymentRequired")
    public DemoResult demoNoPaymentRequired(@RequestParam(value="name", defaultValue="No Payment Required") String name) {
        return new DemoResult(counter.incrementAndGet(),
                String.format(template, paywallProperties.getLndHostname()));
    }
    }

