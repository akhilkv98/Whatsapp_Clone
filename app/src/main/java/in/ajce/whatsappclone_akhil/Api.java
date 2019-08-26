package in.ajce.whatsappclone_akhil;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    @GET("jkc1v")
    Call<List<ChatModel>> getAllChats();

}
