package org.eclipse.n4js.json.ide;

import com.google.inject.Guice;
import com.google.inject.Injector;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.Channels;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;
import org.eclipse.lsp4j.jsonrpc.Launcher;
import org.eclipse.lsp4j.jsonrpc.MessageConsumer;
import org.eclipse.lsp4j.services.LanguageClient;
import org.eclipse.xtext.ide.server.LanguageServerImpl;
import org.eclipse.xtext.ide.server.ServerModule;
import org.eclipse.xtext.xbase.lib.InputOutput;

@SuppressWarnings("all")
public class RunServer {
  public static void main(final String[] args) throws Exception {
    ServerModule _serverModule = new ServerModule();
    final Injector injector = Guice.createInjector(_serverModule);
    AsynchronousServerSocketChannel _open = AsynchronousServerSocketChannel.open();
    InetSocketAddress _inetSocketAddress = new InetSocketAddress("localhost", 5007);
    final AsynchronousServerSocketChannel serverSocket = _open.bind(_inetSocketAddress);
    final ExecutorService threadPool = Executors.newCachedThreadPool();
    while (true) {
      {
        InputOutput.<String>println("started LSP server");
        LanguageServerImpl languageServer = injector.<LanguageServerImpl>getInstance(LanguageServerImpl.class);
        final AsynchronousSocketChannel socketChannel = serverSocket.accept().get();
        final InputStream in = Channels.newInputStream(socketChannel);
        final OutputStream out = Channels.newOutputStream(socketChannel);
        final Function<MessageConsumer, MessageConsumer> _function = (MessageConsumer it) -> {
          return it;
        };
        final Launcher<LanguageClient> launcher = Launcher.<LanguageClient>createIoLauncher(languageServer, LanguageClient.class, in, out, threadPool, _function);
        languageServer.connect(launcher.getRemoteProxy());
        launcher.startListening();
      }
    }
  }
}
