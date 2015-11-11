package jp.vmi.selenium.selenese.command;

import java.net.URI;
import java.net.URISyntaxException;

import com.thoughtworks.selenium.SeleniumException;

import jp.vmi.selenium.selenese.Context;
import jp.vmi.selenium.selenese.result.Result;

import static jp.vmi.selenium.selenese.command.ArgumentType.*;
import static jp.vmi.selenium.selenese.result.Success.*;

/**
 * Command "open".
 */
public class Open extends AbstractCommand {

    private static final int ARG_URL = 0;

    Open(int index, String name, String... args) {
        super(index, name, args, VALUE);
    }

    @Override
    protected Result executeImpl(Context context, String... curArgs) {
        String url = curArgs[ARG_URL];
        if (!url.contains("://")) {
            String baseURL = context.getCurrentBaseURL();
            try {
                url = new URI(baseURL).resolve(url).toASCIIString();
            } catch (URISyntaxException e) {
                throw new SeleniumException("Invalid URL: baseURL=[" + baseURL + "] / parameter=[" + url + "]", e);
            }
        }
        context.getWrappedDriver().get(url);
        return SUCCESS;
    }
}
