package dk.nodes.nstack.shared

import kotlinx.coroutines.CoroutineDispatcher

internal expect val ApplicationDispatcher: CoroutineDispatcher

internal expect val nMeta: String