package client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import com.google.gson.Gson;
import dependencies.fileprocessing.TransmissionObject;
import dependencies.fileprocessing.TransmissionObjectType;
import dependencies.fileprocessing.gpx.GpxResults;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import dependencies.Utilities;
import dependencies.fileprocessing.gpx.GpxFile;

public class Client {

    private static final Logger LOGGER = LoggerFactory.getLogger(Client.class);
    private String username;
//    private GpxFile gpxFile;

    private Socket socket;
    private ObjectOutputStream outputStream;
    private ObjectInputStream inputStream;

    private Gson gson = new Gson();

    public Client(String host_address, int port) {

        try {
            this.socket = new Socket(host_address, port);

            this.outputStream = new ObjectOutputStream(socket.getOutputStream());

            this.inputStream = new ObjectInputStream(socket.getInputStream());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendClientInfo(TransmissionObject to) {
        try {
            String jsonString = gson.toJson(to);

            this.outputStream.writeObject(jsonString);
            this.outputStream.flush();


        } catch (IOException e) {
            System.out.println("error");
        }

    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        Client c = new Client(Utilities.HOST_ADDRESS, Utilities.CLIENTS_PORT);

        Scanner s = new Scanner(System.in);
        String username = "ionas";
        String password = "ionas";

        TransmissionObject to = new TransmissionObject();
        to.type = TransmissionObjectType.REGISTRATION_MESSAGE;
        to.username = username;
        to.password = password;
        c.sendClientInfo(to);

        String answer = (String) c.inputStream.readObject();
        System.out.println(answer);

        TimeUnit.SECONDS.sleep(2);

        TransmissionObject to2 = new TransmissionObject();
        to2.type = TransmissionObjectType.GPX_FILE;
        to2.gpxFile = gpxFile2;
        to2.message = "Another ROute";
        c.sendClientInfo(to2);
        String answer2 = (String) c.inputStream.readObject();
        System.out.println(answer2);
        while (true) {

        }
    }

    static String gpxFile2 = """
            <?xml version="1.0"?>
            <gpx version="1.1" creator="user1">
            <wpt lat="37.97500044083267" lon="23.734124806298066">
                <ele>84.60</ele>
                <time>2023-03-19T18:03:56Z</time>
            </wpt>
            <wpt lat="37.974226295610016" lon="23.733947780503083">
                <ele>86.31</ele>
                <time>2023-03-19T18:04:13Z</time>
            </wpt>
            <wpt lat="37.9738372537812" lon="23.733878043068696">
                <ele>88.02</ele>
                <time>2023-03-19T18:04:21Z</time>
            </wpt>
            <wpt lat="37.97348626862293" lon="23.73380830563431">
                <ele>89.62</ele>
                <time>2023-03-19T18:04:28Z</time>
            </wpt>
            <wpt lat="37.97308876533275" lon="23.733679559601594">
                <ele>90.87</ele>
                <time>2023-03-19T18:04:37Z</time>
            </wpt>
            <wpt lat="37.97271420257304" lon="23.733638555802518">
                <ele>91.69</ele>
                <time>2023-03-19T18:04:45Z</time>
            </wpt>
            <wpt lat="37.97232092391624" lon="23.733434707917386">
                <ele>91.84</ele>
                <time>2023-03-19T18:04:54Z</time>
            </wpt>
            <wpt lat="37.97199953334194" lon="23.733756572999173">
                <ele>89.72</ele>
                <time>2023-03-19T18:05:03Z</time>
            </wpt>
            <wpt lat="37.97135588064289" lon="23.733291355594574">
                <ele>86.51</ele>
                <time>2023-03-19T18:05:19Z</time>
            </wpt>
            <wpt lat="37.971072545827475" lon="23.733323542102752">
                <ele>84.99</ele>
                <time>2023-03-19T18:05:25Z</time>
            </wpt>
            <wpt lat="37.97062851145428" lon="23.733484474643646">
                <ele>82.94</ele>
                <time>2023-03-19T18:05:35Z</time>
            </wpt>
            <wpt lat="37.97023842764441" lon="23.734469952498205">
                <ele>80.27</ele>
                <time>2023-03-19T18:05:54Z</time>
            </wpt>
            <wpt lat="37.96998469116279" lon="23.73512441149784">
                <ele>78.37</ele>
                <time>2023-03-19T18:06:06Z</time>
            </wpt>
            <wpt lat="37.96959618006312" lon="23.735986679318426">
                <ele>76.26</ele>
                <time>2023-03-19T18:06:23Z</time>
            </wpt>
            <wpt lat="37.96940164713718" lon="23.736582129719732">
                <ele>75.53</ele>
                <time>2023-03-19T18:06:34Z</time>
            </wpt>
            <wpt lat="37.96919933933833" lon="23.737580208951673">
                <ele>75.92</ele>
                <time>2023-03-19T18:06:52Z</time>
            </wpt>
            <wpt lat="37.96925008724767" lon="23.738293676549635">
                <ele>78.13</ele>
                <time>2023-03-19T18:07:04Z</time>
            </wpt>
            <wpt lat="37.96961041213843" lon="23.739162753309593">
                <ele>80.92</ele>
                <time>2023-03-19T18:07:21Z</time>
            </wpt>
            <wpt lat="37.970706112845036" lon="23.741138942881136">
                <ele>82.30</ele>
                <time>2023-03-19T18:08:03Z</time>
            </wpt>
            <wpt lat="37.97186482424909" lon="23.74279118363431">
                <ele>85.14</ele>
                <time>2023-03-19T18:08:41Z</time>
            </wpt>
            <wpt lat="37.97293689253472" lon="23.74432545436709">
                <ele>89.33</ele>
                <time>2023-03-19T18:09:16Z</time>
            </wpt>
            <wpt lat="37.973985622137214" lon="23.745881135595727">
                <ele>93.19</ele>
                <time>2023-03-19T18:09:51Z</time>
            </wpt>
            <wpt lat="37.974887136607" lon="23.747394418521736">
                <ele>98.09</ele>
                <time>2023-03-19T18:10:24Z</time>
            </wpt>
            <wpt lat="37.97578360837828" lon="23.748660421176766">
                <ele>104.00</ele>
                <time>2023-03-19T18:10:53Z</time>
            </wpt>
            <wpt lat="37.976571754174486" lon="23.748482160789596">
                <ele>106.65</ele>
                <time>2023-03-19T18:11:10Z</time>
            </wpt>
            <wpt lat="37.97627575373355" lon="23.747065954429733">
                <ele>104.68</ele>
                <time>2023-03-19T18:11:35Z</time>
            </wpt>
            <wpt lat="37.97594596339027" lon="23.74577874861979">
                <ele>103.78</ele>
                <time>2023-03-19T18:11:58Z</time>
            </wpt>
            <wpt lat="37.97560415124092" lon="23.74435449907545">
                <ele>102.97</ele>
                <time>2023-03-19T18:12:24Z</time>
            </wpt>
            <wpt lat="37.97531237553971" lon="23.74304558107618">
                <ele>102.26</ele>
                <time>2023-03-19T18:12:47Z</time>
            </wpt>
            <wpt lat="37.97544769195116" lon="23.74206389257673">
                <ele>102.70</ele>
                <time>2023-03-19T18:13:04Z</time>
            </wpt>
            <wpt lat="37.97557032223354" lon="23.741135848257578">
                <ele>103.21</ele>
                <time>2023-03-19T18:13:20Z</time>
            </wpt>
            <wpt lat="37.97564220885555" lon="23.740443838331736">
                <ele>103.85</ele>
                <time>2023-03-19T18:13:32Z</time>
            </wpt>
            <wpt lat="37.97580712495767" lon="23.739042060946247">
                <ele>103.94</ele>
                <time>2023-03-19T18:13:56Z</time>
            </wpt>
            <wpt lat="37.97589169717401" lon="23.738403695200702">
                <ele>102.26</ele>
                <time>2023-03-19T18:14:07Z</time>
            </wpt>
            <wpt lat="37.975984726499426" lon="23.737593668078205">
                <ele>99.81</ele>
                <time>2023-03-19T18:14:21Z</time>
            </wpt>
            <wpt lat="37.97670934920536" lon="23.737739976750063">
                <ele>100.49</ele>
                <time>2023-03-19T18:14:37Z</time>
            </wpt>
            <wpt lat="37.97699689080875" lon="23.73778825651233">
                <ele>100.75</ele>
                <time>2023-03-19T18:14:43Z</time>
            </wpt>
            <wpt lat="37.977449343697856" lon="23.737691696987795">
                <ele>100.74</ele>
                <time>2023-03-19T18:14:53Z</time>
            </wpt>
            <wpt lat="37.97786796584944" lon="23.737273272381472">
                <ele>100.12</ele>
                <time>2023-03-19T18:15:04Z</time>
            </wpt>
            <wpt lat="37.97842361239339" lon="23.73691624708171">
                <ele>100.03</ele>
                <time>2023-03-19T18:15:17Z</time>
            </wpt>
            <wpt lat="37.97891411240534" lon="23.736481729221296">
                <ele>99.96</ele>
                <time>2023-03-19T18:15:30Z</time>
            </wpt>
            <wpt lat="37.97959013557169" lon="23.73598551874211">
                <ele>97.81</ele>
                <time>2023-03-19T18:15:47Z</time>
            </wpt>
            <wpt lat="37.980232848842846" lon="23.735309602070355">
                <ele>93.81</ele>
                <time>2023-03-19T18:16:05Z</time>
            </wpt>
            <wpt lat="37.98072736937688" lon="23.734927883970148">
                <ele>91.69</ele>
                <time>2023-03-19T18:16:17Z</time>
            </wpt>
            <wpt lat="37.98134047463319" lon="23.73435925565899">
                <ele>89.41</ele>
                <time>2023-03-19T18:16:33Z</time>
            </wpt>
            <wpt lat="37.98184786821304" lon="23.734069577085382">
                <ele>88.26</ele>
                <time>2023-03-19T18:16:45Z</time>
            </wpt>
            <wpt lat="37.98287437425815" lon="23.733200541364557">
                <ele>85.74</ele>
                <time>2023-03-19T18:17:12Z</time>
            </wpt>
            <wpt lat="37.98257839923655" lon="23.73259436212719">
                <ele>83.76</ele>
                <time>2023-03-19T18:17:24Z</time>
            </wpt>
            <wpt lat="37.982273966540326" lon="23.732068649160272">
                <ele>81.70</ele>
                <time>2023-03-19T18:17:35Z</time>
            </wpt>
            <wpt lat="37.98199067386906" lon="23.731526842939264">
                <ele>79.69</ele>
                <time>2023-03-19T18:17:46Z</time>
            </wpt>
            <wpt lat="37.981516710668835" lon="23.731937097069853">
                <ele>80.95</ele>
                <time>2023-03-19T18:17:58Z</time>
            </wpt>
            <wpt lat="37.98108542440336" lon="23.732312606331938">
                <ele>82.56</ele>
                <time>2023-03-19T18:18:09Z</time>
            </wpt>
            <wpt lat="37.98054835458768" lon="23.732698844430082">
                <ele>84.50</ele>
                <time>2023-03-19T18:18:22Z</time>
            </wpt>
            <wpt lat="37.98021854331955" lon="23.73299925183975">
                <ele>85.58</ele>
                <time>2023-03-19T18:18:31Z</time>
            </wpt>
            <wpt lat="37.97995638458757" lon="23.73328356599533">
                <ele>86.31</ele>
                <time>2023-03-19T18:18:38Z</time>
            </wpt>
            <wpt lat="37.97948524234685" lon="23.73360438799769">
                <ele>87.15</ele>
                <time>2023-03-19T18:18:49Z</time>
            </wpt>
            <wpt lat="37.97916811156095" lon="23.733926253079478">
                <ele>87.90</ele>
                <time>2023-03-19T18:18:58Z</time>
            </wpt>
            <wpt lat="37.97872835460352" lon="23.734274940251414">
                <ele>89.01</ele>
                <time>2023-03-19T18:19:09Z</time>
            </wpt>
            <wpt lat="37.977979166713254" lon="23.73488202163598">
                <ele>90.98</ele>
                <time>2023-03-19T18:19:28Z</time>
            </wpt>
            <wpt lat="37.97723902527248" lon="23.7356089968785">
                <ele>92.09</ele>
                <time>2023-03-19T18:19:48Z</time>
            </wpt>
            <wpt lat="37.97687280742373" lon="23.735908828133965">
                <ele>92.61</ele>
                <time>2023-03-19T18:19:57Z</time>
            </wpt>
            <wpt lat="37.97645840817195" lon="23.735860548371697">
                <ele>93.29</ele>
                <time>2023-03-19T18:20:06Z</time>
            </wpt>
            <wpt lat="37.975764918475925" lon="23.73574789559307">
                <ele>93.90</ele>
                <time>2023-03-19T18:20:21Z</time>
            </wpt>
            <wpt lat="37.97523633961217" lon="23.735645971650506">
                <ele>93.59</ele>
                <time>2023-03-19T18:20:32Z</time>
            </wpt>
            </gpx>
              
            """;
}
