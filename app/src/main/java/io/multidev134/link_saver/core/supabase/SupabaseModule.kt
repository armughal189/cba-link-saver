package io.multidev134.link_saver.core.supabase

import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Module
class SupabaseModule {
  @Single
  fun provideSupabaseClient(): SupabaseClient {
    return createSupabaseClient(
      supabaseUrl = "https://jeqvhjtfqphzknyywymy.supabase.co",
      supabaseKey = "sb_publishable_adU2EAlVa4tG1jTZVdYv-A_YY8GWveL"
    ) {
      install(Postgrest)
      install(Auth)
    }
  }
}