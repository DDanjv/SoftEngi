import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import api.ComputationServiceGrpc;
import api.ComputationServiceGrpc.ComputationServiceBlockingStub;
import api.ComputationServiceOuterClass.ComputeRequest;
import api.ComputationServiceOuterClass.ComputeResponse;
import api.ComputationServiceOuterClass.input;
import api.ComputationServiceOuterClass.output;
import io.grpc.Channel;
import io.grpc.Grpc;
import io.grpc.InsecureChannelCredentials;
import io.grpc.ManagedChannel;
import io.grpc.StatusRuntimeException;
import java.util.ArrayList;
import java.util.List;
 
//call the coordite 
public class ComputecordClient { 
    private final ComputationServiceBlockingStub blockingStub; 

    public ComputecordClient(Channel channel) {
        blockingStub = ComputationServiceGrpc.newBlockingStub(channel); 
    }

    public void order(List<Integer> a, String b) {
        input in  = input.newBuilder().addAllList(a).build();
        output out = output.newBuilder().setOut(b).build();
        ComputeRequest request = ComputeRequest.newBuilder().setObj(in).setObj2(out).build();

        ComputeResponse response;
        try {
            response = blockingStub.compute(request); //sever call 
            System.out.println(response.getResult());

        } catch (StatusRuntimeException e) {
            e.printStackTrace();
            return;
        }
        if (response.hasErrorMessage()) {
            System.err.println("Error: " + response.getErrorMessage());
        } else {
            System.out.println("Response: " + response);
        }
    }

    public static void main(String[] args) throws Exception {
        String target = "localhost:50051"; 

        ManagedChannel channel = Grpc.newChannelBuilder(target, InsecureChannelCredentials.create())
                .build();
        Scanner scanner = new Scanner(System.in);
        System.out.println("give input file pls: ");
        String fileName = scanner.nextLine();
        System.out.println("give output file pls: ");
        String outputname = scanner.nextLine();
        // src\\f.test to call file
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line ; 
            List<Integer> nums = new ArrayList<Integer>();
            while ((line = reader.readLine()) != null) {
                nums.add(Integer.parseInt(line.trim()));
            }
            System.out.println(nums);
            ComputecordClient client = new ComputecordClient(channel);
            client.order(nums, outputname);


        }catch (IOException e) {

            System.err.println("Error: An I/O error occurred while accessing the file. Details: " + e.getMessage());

        } catch (RuntimeException e) {

            System.err.println("Error: A runtime error occurred. Details: " + e.getMessage());

        } finally {

            channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
            scanner.close();
        }
    }
}
