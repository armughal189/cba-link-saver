package io.multidev134.link_saver.core.supabase

import android.content.Context
import com.russhwolf.settings.SharedPreferencesSettings
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.auth.SettingsSessionManager
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Module
class SupabaseModule {
  @Single
  fun provideSupabaseClient(context: Context): SupabaseClient {
    return createSupabaseClient(
      supabaseUrl = "https://jeqvhjtfqphzknyywymy.supabase.co",
      supabaseKey = "sb_publishable_adU2EAlVa4tG1jTZVdYv-A_YY8GWveL"
    ) {
      install(Postgrest)
      install(Auth) {
        sessionManager = SettingsSessionManager(SharedPreferencesSettings(context.getSharedPreferences("supabase_space", Context.MODE_PRIVATE)))
      }
    }
  }
}