package org.example.ktz.rxjava.chap5.single;

import com.ning.http.client.AsyncCompletionHandler;
import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.Response;
import rx.Single;
import rx.SingleSubscriber;

import java.io.IOException;

public class SingleHttpRequest {

    public static AsyncHttpClient asyncHttpClient = new AsyncHttpClient();

    public static void main(String[] args) {
        Single<String> example =
                SingleHttpRequest
                        .fetch("http://example.com")
                        .flatMap(SingleHttpRequest::body);

        example.subscribe(System.out::println, e -> System.out.println(e.toString()));
        // Parameter가 2개 뿐이다. 어짜피 next만 있고 바로 끝나니까!

        example.toBlocking().value();
    }

    public static Single<Response> fetch(String address) {
        return Single.create(subscriber ->
                asyncHttpClient.prepareGet(address).execute(handler(subscriber)));
    }

    public static AsyncCompletionHandler handler(SingleSubscriber<? super Response> subscriber) {

        return new AsyncCompletionHandler() {
            @Override
            public Response onCompleted(Response response) throws Exception {
                subscriber.onSuccess(response);

                return response;
            }

            @Override
            public void onThrowable(Throwable t) {
                subscriber.onError(t);
            }
        };
    }

    public static Single<String> body(Response response) {
        return Single.create(subscriber -> {
            try {
                subscriber.onSuccess(response.getResponseBody());
            } catch (IOException e) {
                subscriber.onError(e);
            }
        });
    }
}
