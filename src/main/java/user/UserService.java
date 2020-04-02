package user;

import com.yrrhelp.grpc.User;
import com.yrrhelp.grpc.userGrpc;
import io.grpc.stub.StreamObserver;

public class UserService extends userGrpc.userImplBase {

    @Override
    public void login(User.LoginRequest request, StreamObserver<User.APIResponse> responseObserver) {
//        super.login(request, responseObserver);
        System.out.println("Inside login");

        String username = request.getUsername();
        String password = request.getPasswd();
        User.APIResponse.Builder response = User.APIResponse.newBuilder();
        if (username.equals(password)){
            response.setResponseCode(0).setResponsemessage("SUCCESS");
        }else{
            response.setResponseCode(100).setResponsemessage("INVALID PASSWD");

        }

        responseObserver.onNext(response.build());
        responseObserver.onCompleted();

    }

    @Override
    public void logout(User.Empty request, StreamObserver<User.APIResponse> responseObserver) {
        super.logout(request, responseObserver);
    }
}
