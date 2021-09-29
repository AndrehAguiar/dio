import java.io.IOException;
import java.net.ProxySelector;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class RequestHttp {

    static ExecutorService executor = Executors.newFixedThreadPool(6, new ThreadFactory(){
        @Override
        public Thread newThread(Runnable runnable){
            Thread thread = new Thread(runnable);

            System.out.println("Nova Thread criada :: "
                    +(thread.isDaemon()? "daemon": "")
                    +" Thread Group" + thread.getThreadGroup());

            return thread;
        }
    });

    public static void main(String[] args) throws Exception {
        //connectAndPrintURLJavaOracle();  throws IOException, InterruptedException
        connectAkamiHttpClient();
    }

    private static void connectAkamiHttpClient() throws Exception{
        System.out.println("Running HTTP/2 example ..."); // Change to HTTP/1.1
        try{
            HttpClient httpClient = HttpClient.newBuilder()
                    .version(HttpClient.Version.HTTP_2) // Change to HTTP_1_1
                    .proxy(ProxySelector.getDefault())
                    .build();

            long start = System.currentTimeMillis();
            HttpRequest mainRequest = HttpRequest.newBuilder()
                    .uri(URI.create("https://http2.akamai.com/demo/h2_demo_frame.html"))
                    .build();
            HttpResponse<String> response = httpClient.send(mainRequest, HttpResponse.BodyHandlers.ofString());

            System.out.println(String.format("Status code :: %s", response.statusCode()));
            System.out.println(String.format("Headers response :: %s", response.headers()));

            String responseBody = response.body();
            System.out.println(responseBody);

            List<Future<?>> future = new ArrayList<>();

            responseBody
                    .lines()
                    .filter(line -> line.trim().startsWith("<img height"))
                    .map(line -> line.substring(line.indexOf("src='") + 5, line.indexOf("'/>")))
                    .forEach(image -> {
                        Future<?> imgFuture = executor.submit(() -> {
                            HttpRequest imgRequest = HttpRequest.newBuilder()
                                    .uri(URI.create("https://http2.akamai.com"+image))
                                    .build();

                            try {
                                HttpResponse<String> imgResponse = httpClient.send(imgRequest, HttpResponse.BodyHandlers.ofString());
                                System.out.println("Imagem Carregada :: "+image+", status code ::"+imgResponse.statusCode());

                            } catch (IOException | InterruptedException e) {
                                System.out.println("Erro na requisição das para recuperar a imagem "+image);
                            }
                        });
                        future.add(imgFuture);
                        System.out.println("Submetido um futuro para imagem " + image);
                    });

            future.forEach(f ->{
                try {
                    f.get();
                } catch (InterruptedException | ExecutionException e) {
                    System.out.println("Erro na espera do carregamento da imagem futuro");
                }
            });

            long end = System.currentTimeMillis();
            System.out.println("Tempo de carregamento total :: " + (end - start) + " ms");

        }catch (InterruptedException | IOException e){
            e.printStackTrace();
        }finally {
            executor.shutdown();
        }
    }

    private static void connectAndPrintURLJavaOracle() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .GET().uri(URI.create("https://docs.oracle.com/javase/10/language/"))
                .build();

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(String.format("Status code :: %s", response.statusCode()));
        System.out.println(String.format("Headers response :: %s", response.headers()));
        System.out.println(response.body());
    }
}
