/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * Copyright (c) 2011, Red Hat Inc. or third-party contributors as
 * indicated by the @author tags or express copyright attribution
 * statements applied by the authors.  All third-party contributions are
 * distributed under license by Red Hat Inc.
 *
 * This copyrighted material is made available to anyone wishing to use, modify,
 * copy, or redistribute it subject to the terms and conditions of the GNU
 * Lesser General Public License, as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License
 * for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this distribution; if not, write to:
 * Free Software Foundation, Inc.
 * 51 Franklin Street, Fifth Floor
 * Boston, MA  02110-1301  USA
 */
package org.hibernate.cache.ehcache.internal.strategy;

import org.hibernate.cache.ehcache.internal.regions.EhcacheCollectionRegion;
import org.hibernate.cache.ehcache.internal.regions.EhcacheEntityRegion;
import org.hibernate.cache.spi.access.AccessType;
import org.hibernate.cache.spi.access.CollectionRegionAccessStrategy;
import org.hibernate.cache.spi.access.EntityRegionAccessStrategy;

/**
 * Factory to create {@link EntityRegionAccessStrategy}
 *
 * @author Abhishek Sanoujam
 * @author Alex Snaps
 */
public interface EhcacheAccessStrategyFactory {

	/**
	 * Create {@link EntityRegionAccessStrategy} for the input {@link EhcacheEntityRegion} and {@link AccessType}
	 *
	 * @param entityRegion
	 * @param accessType
	 *
	 * @return the created {@link EntityRegionAccessStrategy}
	 */
	public EntityRegionAccessStrategy createEntityRegionAccessStrategy(EhcacheEntityRegion entityRegion, AccessType accessType);

	/**
	 * Create {@link CollectionRegionAccessStrategy} for the input {@link org.hibernate.cache.ehcache.internal.regions.EhcacheCollectionRegion} and {@link AccessType}
	 *
	 * @param collectionRegion
	 * @param accessType
	 *
	 * @return the created {@link CollectionRegionAccessStrategy}
	 */
	public CollectionRegionAccessStrategy createCollectionRegionAccessStrategy(EhcacheCollectionRegion collectionRegion,
																			   AccessType accessType);

}
