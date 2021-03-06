package app.tugas.finalproject.network

import app.tugas.finalproject.model.response.Event
import app.tugas.finalproject.model.response.League
import app.tugas.finalproject.model.response.ListResponse
import app.tugas.finalproject.model.response.Player
import app.tugas.finalproject.model.response.Team
import io.reactivex.Flowable
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface TheSportDBApiService {

    @GET("api/v1/json/1/all_leagues.php")
    fun getAllLeagues(): Observable<ListResponse<League>>

    @GET("api/v1/json/1/search_all_teams.php")
    fun getAllTeams(@Query("l") league: String) : Observable<ListResponse<Team>>

    @GET("api/v1/json/1/eventspastleague.php")
    fun getLastMatchByLeagueId(@Query("id") leagueId: String): Observable<ListResponse<Event>>

    @GET("api/v1/json/1/eventsnextleague.php")
    fun getNextMatchByLeagueId(@Query("id") leagueId: String): Observable<ListResponse<Event>>

    @GET("api/v1/json/1/lookupevent.php")
    fun getEventByEventId(@Query("id") eventId: String): Observable<ListResponse<Event>>

    @GET("api/v1/json/1/lookupteam.php")
    fun getTeamByTeamId(@Query("id") teamId: String): Observable<ListResponse<Team>>

    @GET("api/v1/json/1/searchevents.php")
    fun searchEvents(@Query("e") query: String?) : Observable<ListResponse<Event>>

    @GET("api/v1/json/1/searchteams.php")
    fun searchTeams(@Query("t") keyword: String): Observable<ListResponse<Team>>

    @GET("api/v1/json/1/lookup_all_players.php")
    fun getAllPlayers(@Query("id") id:String?) : Observable<ListResponse<Player>>
}
