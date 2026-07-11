package io.multidev134.link_saver.core

import io.multidev134.link_saver.core.database.DbModule
import io.multidev134.link_saver.core.supabase.SupabaseModule
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module

@Module(includes = [DbModule::class, SupabaseModule::class])
@ComponentScan("io.multidev134.link_saver")
class AppModule
