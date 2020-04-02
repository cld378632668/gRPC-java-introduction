
import com.yrrhelp.grpc.userGrpc;
import com.yrrhelp.grpc.User;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.concurrent.TimeUnit;


public class GrpcClient {
    public static void main(String[] args) throws InterruptedException {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090).usePlaintext().build();

        // stubs - generate from proto
        userGrpc.userBlockingStub userStub = userGrpc.newBlockingStub(channel);

        String value;
        User.LoginRequest loginRequest = User.LoginRequest.newBuilder().setUsername("RAMabc").setPasswd("RAM").build();
        User.APIResponse response = userStub.login(loginRequest); // 运行到这一行卡住
        System.out.println("1111");
        System.out.println(response.getResponsemessage());

        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);


    }
}
